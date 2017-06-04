package com.ll.studies.questions;

import java.awt.Point;
import java.util.*;


public class QuestionE {
    private static final int COFFEE_VALUE = -4;
    private static final int ME_VALUE = -3;
    private static final int INVALID_VALUE = -2;
    private static final int VALID_VALUE = Integer.MAX_VALUE;

    /**
     E. Motorola quer certificar-se de que todos os seus engenheiros estão perto de uma máquina de café.
        Dada uma planta do escritório mostrando as localizações de todas as máquinas de café, determine até onde
        cada engenheiro está da máquina de café mais próxima.
        O escritório pode ser representado como uma matriz 2D onde cada célula contém exatamente um dos seguintes:
 		uma mesa de engenheiro, uma parede (intransitável) ou uma máquina de café.
 		A distância é definida como o número de passos que o engenheiro teria de levar para chegar a uma máquina de café,
 		movendo-se para cima, para baixo, para a esquerda e para a direita para salas adjacentes sem ser capaz de
 		passar através das paredes.
        A função deve retornar uma matriz de número inteiro 2D contendo as distâncias.
		Os candidatos devem perguntar sobre, e então explicitamente definir,
		o valor de um quadrado inacessível; -1 funciona bem para isso. Eu fornecerei isto mais tarde se eles não perguntarem.
     */
    public static void question(Point me, List<Point> coffees) {
        int width, height;
        width = height = 10;
        char[][] board = generateOffice();
        int[][] map;

        // Drawing me and coffee machine
        board[me.x][me.y] = 'O';

        for (Point coffee : coffees) {
            board[coffee.x][coffee.y] = 'C';
        }

        System.out.println("Original:");
        print(board, width, height);
        map = convertToMap(board, width, height);
        generatePath(map, coffees, width, height);

        if (map[me.x][me.y] == ME_VALUE) {
            System.out.println("Machine coffee is not reachable!");
        } else {
            int x = me.x;
            int y = me.y;
            int step = map[x][y];

            while (step > 1) {
                step--;
                // check right
                if (x > 0) {
                    if (map[x - 1][y] == COFFEE_VALUE) {
                        break;
                    }
                    if (map[x - 1][y] == step) {
                        x--;
                        board[x][y] = 'x';
                        continue;
                    }
                }

                // check right
                if (x < width - 1) {
                    if (map[x + 1][y] == COFFEE_VALUE) {
                        break;
                    }
                    if (map[x + 1][y] == step) {
                        x++;
                        board[x][y] = 'x';
                        continue;
                    }
                }

                // check top
                if (y > 0) {
                    if (map[x][y - 1] == COFFEE_VALUE) {
                        break;
                    }
                    if (map[x][y - 1] == step) {
                        y--;
                        board[x][y] = 'x';
                        continue;
                    }
                }

                // check bottom
                if (y < height - 1) {
                    if (map[x][y + 1] == COFFEE_VALUE) {
                        break;
                    }
                    if (map[x][y + 1] == step) {
                        y++;
                        board[x][y] = 'x';
                        continue;
                    }
                }
            }
        }

        System.out.println("\nAnswer:");
        print(board, width, height);
    }

    public static int[][] convertToMap(char[][] board, int width, int height) {
        int[][] map = new int[width][height];
        int value;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                switch (board[i][j]) {
                    case 'O':
                        value = ME_VALUE;
                        break;
                    case '-':
                        value = VALID_VALUE;
                        break;
                    case 'C':
                        value = COFFEE_VALUE;
                        break;
                    default:
                        value = INVALID_VALUE;
                        break;
                }
                map[i][j] = value;
            }
        }
        return map;
    }

    public static void generatePath(int[][] map, List<Point> coffees, int width, int height) {
        LinkedList<Point> queues = new LinkedList();
        int x, y, level;
        Point current;
        for (Point coffee : coffees) {
            queues.addLast(coffee);
            map[coffee.x][coffee.y] = 0;
        }

        while (!queues.isEmpty()) {
            current = queues.removeFirst();
            x = current.x;
            y = current.y;
            level = map[x][y] + 1;
            // check left
            if (x > 0) {
                if (map[x - 1][y] == ME_VALUE) {
                    map[x - 1][y] = level;
                    return;
                }
                if (map[x - 1][y] > level) {
                    map[x - 1][y] = level;
                    queues.addLast(new Point(x - 1, y));
                }
            }

            // check right
            if (x < width - 1) {
                if (map[x + 1][y] == ME_VALUE) {
                    map[x + 1][y] = level;
                    return;
                }
                if (map[x + 1][y] > level) {
                    map[x + 1][y] = level;
                    queues.addLast(new Point(x + 1, y));
                }
            }

            // check top
            if (y > 0) {
                if (map[x][y - 1] == ME_VALUE) {
                    map[x][y - 1] = level;
                    return;
                }
                if (map[x][y - 1] > level) {
                    map[x][y - 1] = level;
                    queues.addLast(new Point(x, y - 1));
                }
            }

            // check bottom
            if (y < height - 1) {
                if (map[x][y + 1] == ME_VALUE) {
                    map[x][y + 1] = level;
                    return;
                }
                if (map[x][y + 1] > level) {
                    map[x][y + 1] = level;
                    queues.addLast(new Point(x, y + 1));
                }
            }
        }
    }

    public static char[][] generateOffice() {
        return new char[][]{
                new char[]{'-', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                new char[]{'-', '*', '-', '-', '*', '-', '-', '-', '*', '*'},
                new char[]{'-', '*', '*', '*', '*', '*', '-', '-', '-', '-'},
                new char[]{'-', '-', '-', '*', '-', '-', '-', '*', '-', '-'},
                new char[]{'-', '-', '-', '*', '*', '*', '-', '*', '-', '-'},
                new char[]{'*', '-', '-', '-', '-', '*', '-', '-', '-', '*'},
                new char[]{'*', '-', '-', '*', '-', '*', '-', '*', '-', '-'},
                new char[]{'-', '-', '-', '*', '-', '*', '-', '*', '-', '-'},
                new char[]{'-', '-', '-', '*', '-', '*', '*', '*', '-', '*'},
                new char[]{'-', '*', '*', '*', '-', '-', '-', '-', '-', '-'}
        };
    }

    public static void print(char[][] office, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(office[i][j]);
            }
            System.out.println("");
        }
    }

    public static void print(int[][] map, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(String.format("%02d ", map[i][j]));
            }
            System.out.println("");
        }
    }
}
