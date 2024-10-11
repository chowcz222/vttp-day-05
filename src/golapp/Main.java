package src.golapp;

import java.io.*;


public class Main{

    public static void main(String[] args) {

        Console cons = System.console();
        String tempSize = cons.readLine("GRID ");
        String[] gridSize = tempSize.split(" ");
        String[][] grid = new String[Integer.parseInt(gridSize[0])][Integer.parseInt(gridSize[1])];
        String[][] grid2 = new String[Integer.parseInt(gridSize[0])][Integer.parseInt(gridSize[1])];
        for (int i = 0; i < Integer.parseInt(gridSize[0]); i++) {
            for (int j = 0; j < Integer.parseInt(gridSize[1]); j++) {
                    grid[i][j] = " ";
                    grid2[i][j] = " ";
            }
        }

        String tempStart = cons.readLine("START ");
        String[] startCoords = tempStart.split(" ");
        int xStart = Integer.parseInt(startCoords[0]);
        int yStart = Integer.parseInt(startCoords[1]);

        System.out.println("DATA");

        for( int yMax = yStart ; yMax < ((Integer.parseInt(gridSize[1]) + 1 - yStart)) ; yMax++) {
            String tempData = cons.readLine("Input  ");
            int xmin = xStart;
            if(tempData != "") {
                String[] gridData = tempData.split("");
                for (int a = 0; a < gridData.length ; a++ ) {
                    grid[xmin][yMax] = gridData[a];
                    xmin++;
                }
            } else { break;}
        }
        
        for ( int y =0 ; y < Integer.parseInt(gridSize[1]) ; y++) {
            for ( int x =0 ; x < Integer.parseInt(gridSize[0]) ; x++) {

                System.out.printf(grid[x][y]);
            }
            System.out.println("\n");
        }

        System.out.println("\n\n\n");



        for(int z= 0; z<5 ; z++){

            for ( int b = 0 ; b < Integer.parseInt(gridSize[0]) ; b++) {

                for ( int c = 0 ; c < Integer.parseInt(gridSize[1]) ; c++) {

                    int bmin = b-1;
                    int bmax = b+1;
                    int cmin = c-1;
                    int cmax = c+1;

                    int count = 0;

                    if  (b == 0) {
                        bmin = b;
                    } else if (b == (Integer.parseInt(gridSize[0])-1)) {
                        bmax = b;
                    }

                    if  (c == 0) {
                        cmin = c;
                    } else if (c == (Integer.parseInt(gridSize[1])-1)) {
                        cmax = c;
                    }

                    for ( int i = bmin ; i < (bmax+1) ; i++ ) {

                        for ( int j = cmin ; j < (cmax+1) ; j++) {

                            if( i == b && j ==c && b != c) { continue;}
                            
                            if (grid[i][j].equals("*")) { count++;}
                        }
                    }

                    if ( count == 0 || count == 1) {

                        grid2[b][c] = " ";

                    } else if ( count == 2 ) {
                        
                        if (grid[b][c] == "*") 
                            grid2[b][c] = "*";
            
                    } else if ( count == 3) {

                        grid2[b][c] = "*";

                    } else if ( count >= 4) {

                        grid2[b][c] = " ";
                    }

                }
            
            }

            for ( int y =0 ; y < Integer.parseInt(gridSize[1]) ; y++) {
                for ( int x =0 ; x < Integer.parseInt(gridSize[0]) ; x++) {

                    System.out.printf(grid2[x][y]);
                    grid[x][y] = grid2[x][y];
                }
                System.out.println("\n");
            }

            System.out.println("\n\n\n");
        }
    }
}