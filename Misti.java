public class Misti {
    public static void main(String args[]) {
        boolean hasHuman = false;
        if (Integer.parseInt(args[0])>4||Integer.parseInt(args[0])<2) {
            System.out.println("number of players wrong");
        }
        else {
            Player[] players = new Player[Integer.valueOf(args[0])];
            String fileName = args[1];
            String[] placeHolder = new String[2];
            for (int i=0;i<=Integer.valueOf(args[0])-1;i++) {
                placeHolder = args[i+2].split(",");
                if (placeHolder[1].compareTo("novice")==0) {
                    players[i]= new BotNovice(placeHolder[0], placeHolder[1]);
                }
                else if (placeHolder[1].compareTo("regular")==0) {
                    players[i]= new BotRegular(placeHolder[0], placeHolder[1]);
                }
                else if (placeHolder[1].compareTo("expert")==0) {
                    players[i]= new BotExpert(placeHolder[0], placeHolder[1]);
                }
                else if (placeHolder[1].compareTo("human")==0) {
                    if (players.length==0) {
                        players[i]= new HumanPlayer(placeHolder[0], placeHolder[1]);
                    }
                    else {
                        for (Player p : players) {
                            if (p.getExpertise()=="human") {
                                hasHuman = true;
                            }
                        }
                        if (!hasHuman) {
                            players[i]=new HumanPlayer(placeHolder[0], placeHolder[1]);
                        }
                    }
                }
            }
            Game.start(players,fileName);
        }
    }
}
