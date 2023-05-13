import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game {
    public static void start(Player[] players,String b) {
        System.out.println("-----GAME START-----");
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        ArrayList<Card> deck = Card.cutDeck(Card.shuffleDeck(Card.createDeck(b)),s);
        ArrayList<Card> ground = new ArrayList<Card>();
        String[] logs = new String[4];
        ArrayList<Card> cardsPlayed = new ArrayList<Card>();
        int pointHolder=0;
        System.out.println("deck size ="+deck.size());
        for (int y=1;y<=4;y++) {
            ground.add(deck.get(deck.size()-1));
            cardsPlayed.add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        System.out.println("deck size ="+deck.size());
        for (int i=1;cardsPlayed.size()<52;i++) {
            for (Player p:players) {
                p.getCards(deck);
                for (int q=0;q<=3;q++) {
                    deck.remove(deck.size()-1);
                }
            }
            System.out.println("deck size ="+deck.size());
            for (int j=0;j<=3;j++) {
                logs[j]="";
                for (Player p:players) {
                    pointHolder=0;
                    ground.add(p.playCard(ground,cardsPlayed,s,r));
                    cardsPlayed.add(ground.get(ground.size()-1));
                    logs[j]+=(ground.get(ground.size()-1).getInfo());
                    if (ground.size()>1) {
                        if (same(ground)) {
                            for (Card c:ground) {pointHolder+=c.getValue();}
                            if (mişti(ground)) {
                                pointHolder*=5;
                            }
                            p.getPoints(pointHolder);
                            ground.clear();
                            logs[j]+="! ";
                        }
                        else if (joker(ground)) {
                            for (Card c:ground) {pointHolder+=c.getValue();}
                            p.getPoints(pointHolder);
                            ground.clear();
                            logs[j]+="! ";
                        }
                        else {logs[j]+=" ";}
                    }
                    else {logs[j]+=" ";}
                }
            }
            System.out.print("Hand "+i);
            for (Player p:players) {
                System.out.print(":"+p.getInfo());
            }
            System.out.println();
            System.out.println();
            for (int g=0;g<=3;g++) {
                System.out.println(g+1+"."+logs[g]);
            }
        }
        for (Player p:players) {
            Leaderboard.points(p.getName(),String.valueOf(p.getPoints()),p.getExpertise());
        }
    }

    private static boolean same(ArrayList<Card> ground) {
        if (ground.get(ground.size()-1).getNumber()==ground.get(ground.size()-2).getNumber()) {
            return true;
        }
        return false;
    }

    private static boolean joker(ArrayList<Card> ground) {
        if (ground.get(ground.size()-1).getNumber()==11) {
            return true;
        }
        return false;
    }

    private static boolean mişti(ArrayList<Card> ground) {
        if (ground.size()==2) {return true;}
        return false;
    }
}