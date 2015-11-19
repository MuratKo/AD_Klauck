package Statistik;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Statistik {
	/**
	 * Dauer der Simulation in Millisekunden
	 */
	public static int simulationTime;

	//public static final int NUM_OF_PROCESSES = 1;

	public static void main(String[] args) {
		//int pid; // Aktuelle Prozess-ID

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

		try (PrintWriter writer = new PrintWriter(new BufferedWriter(
				new FileWriter(new File("testData.csv"))))) {
			writer.println("MAX_RAM_PAGES_PER_PROCESS;DEFAULT_LOCALITY_FACTOR;Algorithms;Anzahl Seitenfehler;Anzahl Zugriffe;Seitenfehlerrate");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<List<Float>> ergList = new ArrayList<List<Float>>();

		for (List<Float> erg : ergList) {
			try (PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter(new File("testData.csv"), true)))) {
				writer.print(erg.get(0).intValue() + ";"
						+ erg.get(2).intValue() + ";");
				System.out.print(erg.get(0).intValue() + " "
						+ erg.get(2).intValue() + " ");
				if (erg.get(1) == 0) {
					System.out.print("RANDOM ");
					writer.print("RANDOM;");
				} else if (erg.get(1) == 1) {
					System.out.print("CLOCK ");
					writer.print("CLOCK;");
				} else {
					System.out.print("FIFO ");
					writer.print("FIFO;");
				}
				writer.println(erg.get(3).intValue() + ";"
						+ erg.get(4).intValue() + ";" + erg.get(5));
				System.out.println(erg.get(3).intValue() + " "
						+ erg.get(4).intValue() + " " + erg.get(5));

				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

