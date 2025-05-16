/**
 *  Programming problem for ELTE Master's Degree 2025.
 *  Minimum required Java version: 8. Recommended Java version: 17 or higher (LTS).
 *  @author Andre Fernando Llumiquinga Constante
 */
package org.andre;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem1 {
	private static final String FILE_NAME = "./src/input.txt";

	public static void main(String[] args) {
		DailyAirTrafficProcessor processor = DailyAirTrafficProcessor.getInstance(FILE_NAME);
		System.out.println(processor.countFlightsFrom("Frankfurt"));
		System.out.println(processor.getFlightWithMostPassengers());
		System.out.println(processor.getFlightWithPassengersLessThan(100));
		System.out.println(processor.getNameAirlineWithMostTotalOfPassengers());
	}

	static class DailyAirTrafficProcessor {
		private static DailyAirTrafficProcessor INSTANCE;
		private final List<OutboundFlight> information = new ArrayList<>();

		private DailyAirTrafficProcessor(String FILE_NAME) {
			this.loadData(FILE_NAME);
		}

		public static DailyAirTrafficProcessor getInstance(String FILE_NAME) {
			if (INSTANCE == null) INSTANCE = new DailyAirTrafficProcessor(FILE_NAME);
			return INSTANCE;
		}

		private void loadData(String FILE_NAME) {
			try {
				List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
				for (String line : lines) {
					String[] row = line.trim().replaceAll("\\s+", " ").split(" ");
					this.information.add(new OutboundFlight(row[0], row[1], Integer.parseInt(row[2])));
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
			}
		}

		public long countFlightsFrom(String destination) {
			return this.information.stream().filter(airTraffic -> airTraffic.destination.equals(destination)).count();
		}

		public String getFlightWithMostPassengers() {
			return this.information.stream().max(Comparator.comparingInt(OutboundFlight::getPassengerNumber)).map(Object::toString).orElse("The file is empty!");
		}

		public String getFlightWithPassengersLessThan(long value) {
			return this.information.stream().filter(airTraffic -> airTraffic.getPassengerNumber() < value).findFirst().map(Object::toString).orElse("There is no flight with passengers less than " + value + ".");
		}

		public String getNameAirlineWithMostTotalOfPassengers() {
			if (information.isEmpty()) return "The file is empty!";
			Map<String, Integer> passengersByAirline = this.information.stream().collect(Collectors.groupingBy(OutboundFlight::getAirline, Collectors.summingInt(OutboundFlight::getPassengerNumber)));
			Map.Entry<String, Integer> result = passengersByAirline.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
			return result.getKey() + " " + result.getValue();
		}
	}

	static class OutboundFlight {
		private final String airline, destination;
		private final int passengerNumber;

		public OutboundFlight(String airline, String destination, int passengerNumber) {
			this.airline = airline;
			this.destination = destination;
			this.passengerNumber = passengerNumber;
		}

		public String getAirline() {
			return airline;
		}

		public String getDestination() {
			return destination;
		}

		public int getPassengerNumber() {
			return passengerNumber;
		}

		@Override
		public String toString() {
			return this.airline + " " + this.destination + " " + this.passengerNumber;
		}
	}
}