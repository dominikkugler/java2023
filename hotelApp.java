import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private double roomCost;
    private int roomNumberOfPeople;
    private boolean isReserved;

    public Room(int roomNumber, double roomCost, int roomNumberOfPeople) {
        this.roomNumber = roomNumber;
        this.roomCost = roomCost;
        this.roomNumberOfPeople = roomNumberOfPeople;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public int getRoomNumberOfPeople() {
        return roomNumberOfPeople;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
    @Override
    public String toString() {
        return roomNumber + "," + roomCost + "," + roomNumberOfPeople + "," + isReserved;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void displayAllRooms() {
        System.out.println("List of all rooms:");
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Cost per Night: " + room.getRoomCost());
            System.out.println("Number of People: " + room.getRoomNumberOfPeople());
            System.out.println("Reserved: " + (room.isReserved() ? "Yes" : "No"));
            System.out.println("----------------------");
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void reserveRoom(int roomNumber) throws RoomAlreadyBookedException {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isReserved()) {
                    throw new RoomAlreadyBookedException("Room " + roomNumber + " is already booked.");
                } else {
                    room.reserve();
                    System.out.println("Room " + roomNumber + " has been reserved.");
                    return;
                }
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }

    public void cancelReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isReserved()) {
                    room.cancelReservation();
                    System.out.println("Reservation for room " + roomNumber + " has been cancelled.");
                } else {
                    System.out.println("Room " + roomNumber + " is not reserved.");
                }
                return;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }
    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Room room : rooms) {
                writer.println(room.toString());
            }
            System.out.println("Rooms data saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int roomNumber = Integer.parseInt(parts[0]);
                double roomCost = Double.parseDouble(parts[1]);
                int roomNumberOfPeople = Integer.parseInt(parts[2]);
                boolean isReserved = Boolean.parseBoolean(parts[3]);
                Room room = new Room(roomNumber, roomCost, roomNumberOfPeople);
                if (isReserved) {
                    room.reserve();
                }
                rooms.add(room);
            }
            System.out.println("Rooms data loaded from file: " + fileName);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
}

class RoomAlreadyBookedException extends RuntimeException {
    public RoomAlreadyBookedException(String message) {
        super(message);
    }
}

public class hotelApp {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        try {
            hotel.loadFromFile("rooms.dat");
        } catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

        while (true) {
            hotel.displayAllRooms();        

            System.out.println("1. Add Room");
            System.out.println("2. Reserve Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Usuwanie z bufora znaku nowej linii

                switch (choice) {
                    case 1:
                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter room cost: ");
                        double roomCost = scanner.nextDouble();
                        System.out.print("Enter room number of people: ");
                        int roomNumberOfPeople = scanner.nextInt();
                        Room room = new Room(roomNumber, roomCost, roomNumberOfPeople);
                        hotel.addRoom(room);
                        System.out.println("Room added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter room number: ");
                        int reserveRoomNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        hotel.reserveRoom(reserveRoomNumber);
                        break;
                    case 3:
                        System.out.print("Enter room number: ");
                        int cancelRoomNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        hotel.cancelReservation(cancelRoomNumber);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Usuwanie z bufora niepoprawnego znaku
            } catch (RoomAlreadyBookedException e) {
                System.out.println(e.getMessage());
            }
            hotel.saveToFile("rooms.dat");
        }
        
    }
}
