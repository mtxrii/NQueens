//------------------------------------------------------------------------------
// Author: Enrique Davalos (@Mtxrii)
//------------------------------------------------------------------------------

public class Queens {


    static void placeQueen(int[][] B, int i, int j) {
        B[i][j] ++;
        B[i][0] = j;

        int down = j;
        // vertical downwards queen line of sight
        for (int k = i+1; k < B.length; k++) {
            if (k != i) B[k][down] --;
        }

        // diagonal downwards queen line of sight
        for (int l = 1; l < B.length; l++) {
            boolean rightClear = (i + l < B.length && j + l < B.length);
            boolean leftClear  = (i + l < B.length && j - l > 0);

            int right = j + l;
            int left = j - l;
            if (rightClear) B[i + l][right] --;
            if (leftClear) B[i + l][left] --;
        }

    }

    static void removeQueen(int[][] B, int i, int j) {
        B[i][j] --;
        B[i][0] = 0;

        int down = j;
        // vertical downwards queen line of sight
        for (int k = i+1; k < B.length; k++) {
            if (k != i) B[k][down] ++;
        }

        // diagonal downwards queen line of sight
        for (int l = 1; l < B.length; l++) {
            boolean rightClear = (i + l < B.length && j + l < B.length);
            boolean leftClear  = (i + l < B.length && j - l > 0);

            int right = j + l;
            int left = j - l;
            if (rightClear) B[i + l][right] ++;
            if (leftClear) B[i + l][left] ++;
        }
    }

    static void printBoard(int[][] B) {
        int sol = findSolutions(B, 1, ((B[0][1] == 1) ? "verbose" : ""));
        System.out.println((B.length - 1) + "-Queens has " + sol + " solutions");
    }


    static int findSolutions(int[][] B, int i, String mode) {
        int n = B.length-1;
        boolean v = false;
        if (mode.equals("verbose")) v = true;
        StringBuffer print = new StringBuffer("(");

        if (i > n) {
            if (v) {
                for (int e = 1; e < B.length; e++) {
                    print.append(B[e][0]);
                    if (e != n) print.append(", "); //if not at end, keep adding separators to text
                }
                print.append(")");
                System.out.println(print);

            }
            B[0][0] ++;
            return 1;
        }

        else {
            for (int j = 1; j < B.length; j++) {
                if (B[i][j] == 0) {
                    placeQueen(B, i, j);
                    findSolutions(B, i+1, mode);
                    removeQueen(B, i, j);
                }
            }
        }

        return B[0][0];

    }


    public static void main(String[] args) {
        final String usage = "Usage: Queens [-v] number\n" +
                "Option: -v verbose output, print all solutions";

        if (args.length < 1) {
            System.out.println(usage);
            return;
        }

        String ns; // string that holds n
        boolean v;

        if (args.length == 1) {
            v = false;
            ns = args[0];
        }

        else {
            if (!args[0].equals("-v")) {
                System.out.println(usage);
                return;
            }

            v = true;
            ns = args[1];
        }

        int n;

        try {
            n = Integer.parseInt(ns);
        } catch (NumberFormatException e) {
            System.out.println(usage);
            return;
        }


        // Parsing finished.
        // Create board & run other methods.
        int[][] B = new int[n + 1][n + 1];

        // Fill B w/ zeros
        for (int h = 0; h < B.length; h++) {
            for (int g = 0; g < B[h].length; g++) {
                B[h][g] = 0;
            }
        }

        // Fill B[0][2..n]
        for (int i = 2; i < B[0].length; i++) {
            B[0][i] = 420;
        }

        // Put a T/F (1/0) in B[0][1] to indicate mode
        if (v) B[0][1] = 1;
        else B[0][1] = 0;

        printBoard(B);

    }



}
