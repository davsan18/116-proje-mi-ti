public class Misti {
    public static void main(String args[]) {
        if (args.length==0) {
            args = new String[] {"4","","player1,human","player2,novice","player3,regular","player4,expert"};
        }
        if (Integer.parseInt(args[0])>4||Integer.parseInt(args[0])<2) {
            System.out.println("number of players wrong");
        }
        else {
            Player[] players = new Player[Integer.valueOf(args[0])];
            String fileName = args[1];
            String[] placeHolder = new String[2];
            for (int i=0;i<=players.length-1;i++) {
                placeHolder = args[i+2].split(",");
                if (placeHolder[1]=="Novice") {
                    players[i]= new BotNovice(placeHolder[0], placeHolder[1]);
                }
                else if (placeHolder[1]=="regular") {
                    players[i]= new BotRegular(placeHolder[0], placeHolder[1]);
                }
                else if (placeHolder[1]=="expert") {
                    players[i]= new BotExpert(placeHolder[0], placeHolder[1]);
                }
                else {
                    if (i==0) {players[i]= new HumanPlayer(placeHolder[0], placeHolder[1]);}
                    if (HasHuman(players)) {players[i]= new BotNovice(placeHolder[0], placeHolder[1]);}
                    else {players[i]= new HumanPlayer(placeHolder[0], placeHolder[1]);}
                }
            }
            Game.start(players,fileName);
        }
    }

    private static boolean HasHuman(Player[] players) {
        for (Player p:players) {
            if (p.getExpertise().compareTo("human")==0) {
                return true;
            }
        }
        return false;
    }
}
