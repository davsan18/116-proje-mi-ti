public class Misti {
    public static void main(String args[]) {
        Player[] players = new Player[4];
        int pn = Integer.valueOf(args[0]);
        String fileName = args[1];
        String[] placeHolder = new String[2];
        for (int i=0;i<=3;i++) {
            placeHolder = args[i+2].split(",");
            players[i]= new Player(placeHolder[0], placeHolder[1]);
        }
        Game.start(players,fileName);
    }
}
