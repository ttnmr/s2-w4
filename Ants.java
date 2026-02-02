public class Ants {
    public static void main(String[] args) {
        boolean[][] ants = new boolean[100][100];
        ants[0][0] = true;
        while (ants[0][0] || ants[0][1] || ants[0][2] || ants[1][0] || ants[2][0] || ants[1][1]) {
            for (int i = 0; i < ants.length - 1; i++) {
                for (int j = 0; j < ants[0].length - 1; j++) {
                    if (!(ants[i + 1][j] && ants[i][j + 1])) {
                        ants[i][j] = false;
                        ants[i + 1][j] = true;
                        ants[i][j + 1] = true;
                    }
                }
            }
        }
        if (!(ants[0][0] || ants[0][1] || ants[0][2] || ants[1][0] || ants[2][0] || ants[1][1])) {
            System.out.println("Completed");
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (ants[i][j]) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }
    
}