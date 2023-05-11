public class Misti {
    public static void main(String args[]) {
        if (args.length==0) {
            args = new String[] {"4","no text","player1,none","player2,none","player3,none","player4,none"};
        }
        Player[] players = new Player[Integer.valueOf(args[0])];
        String fileName = args[1];
        String[] placeHolder = new String[2];
        for (int i=0;i<=players.length-1;i++) {
            placeHolder = args[i+2].split(",");
            players[i]= new Player(placeHolder[0], placeHolder[1]);
        }
        Game.start(players,fileName);
    }
}
