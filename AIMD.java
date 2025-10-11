import java.util.Random;
import java.util.Scanner;
public class AIMD {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Get initial congestion window size from user
System.out.print("Enter initial congestion window size: ");
int cwnd = scanner.nextInt();
System.out.print("Enter probability of receiving an acknowledgment (0 to 1): ");
double ackProbability = scanner.nextDouble();
System.out.print("Enter probability of packet loss (0 to 1): ");
double lossProbability = scanner.nextDouble();
int ssthresh = Integer.MAX_VALUE; // Initial threshold set to maximum value
int ackCount = 0; // Number of acknowledgments received
Random random = new Random();
System.out.println("\nSimulation started. Press Ctrl+C to terminate.\n");
// Simulate AIMD
while (true) {

System.out.println("Current cwnd: " + cwnd + ", ssthresh: " + ssthresh);
// Send packets up to the current congestion window size
for (int i = 0; i < cwnd; i++) {
sendPacket();
}
// Simulate acknowledgment reception
if (random.nextDouble() <= ackProbability) {
System.out.println("Acknowledgment received.");
ackCount++;
// Additive increase
if (ackCount >= cwnd) {
cwnd++;
ackCount = 0;
}
}
// Simulate packet loss
if (random.nextDouble() <= lossProbability) {
handlePacketLoss(cwnd, ssthresh);
ssthresh = cwnd / 2; // Set new threshold
cwnd = Math.max(1, cwnd / 2); // Multiplicative decrease
ackCount = 0; // Reset acknowledgment count
}
// Slow Start and Congestion Avoidance

if (cwnd < ssthresh) {
// Slow Start Phase: Additive increase
continueAdditiveIncrease(cwnd);
} else {
// Congestion Avoidance Phase
System.out.println("Congestion Avoidance Phase.");
}
// Simulate time passing
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
System.out.println("Simulation interrupted.");
break;
}
}
scanner.close();
}
private static void sendPacket() {
System.out.println("Packet sent.");
}
private static void handlePacketLoss(int cwnd, int ssthresh) {
System.out.println("Packet loss detected! Reducing cwnd and updating ssthresh.");
}

private static void continueAdditiveIncrease(int cwnd) {
System.out.println("Slow Start Phase: Increasing cwnd additively.");
}
}
