import java.util.List; 
import java.util.Scanner;

import controller.GameShopHelper;
import model.Game;

/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Feb 10, 2022
 */

import java.util.List;
import java.util.Scanner;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static GameShopHelper lih = new GameShopHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a publisher: ");
			String publisher = in.nextLine();
			System.out.print("Enter a game: ");
			String game = in.nextLine();
			Game toAdd = new Game(publisher, game);
			lih.insertGame(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the publisher to delete: ");
			String publisher = in.nextLine();
			System.out.print("Enter the game to delete: ");
			String game = in.nextLine();
			Game toDelete = new Game(publisher, game);
			lih.deleteGame(toDelete);4
			+

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Publisher");
			System.out.println("2 : Search by Game Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Game> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Publisher: ");
				String pubName = in.nextLine();
				foundItems	=	lih.searchForGameByPublisher(pubName);
			} else {
				System.out.print("Enter the Game name: ");
				String gameName = in.nextLine();
				foundItems	=	lih.searchForGameByName(gameName);
			}
			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Game l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Game toEdit = lih.searchForGameById(idToEdit);
				System.out.println("Retrieved " + toEdit.getGameName() + " from " + toEdit.getPublisher());
				System.out.println("1 : Update publisher");
				System.out.println("2 : Update game");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Publisher: ");
					String newPub = in.nextLine();
					toEdit.setPublisher(newPub);
				} else if (update == 2) {
					System.out.print("New Game: ");
					String newItem = in.nextLine();
					toEdit.setGameName(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to Gaming List! ---");
			while (goAgain) {
				System.out.println("*  Select a Game:");
				System.out.println("*  1 -- Add a Game");
				System.out.println("*  2 -- Edit a Game");
				System.out.println("*  3 -- Delete a Game");
				System.out.println("*  4 -- View the List");
				System.out.println("*  5 -- Exit the Program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Game> games = lih.showAllGames();
			int id = 1;
			System.out.println();
			for(Game singleItem : games){
				System.out.println(id +". " + singleItem.returnGameDetails());
				id += 1;
			}
			System.out.println();

		}

	}