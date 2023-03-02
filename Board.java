public class Board {

    //�Q�[�����s���t���O
    static boolean game = true;
  
    //�I�Z���łɑΉ������������z��
    static String[][] board = new String[8][8];
  
    static final String EMPTY = "�@";
    static final String BLACK = "��";
    static final String WHITE = "��";
  
    static String stone;
    static String rev_stone;
  
    static public void initialize() {
  
      //�I�Z���ł̗v�f��S�ăN���A����
      for (int i = 0; i < 8; i++) {
  
        for (int j = 0; j < 8; j++) {
  
          board[i][j] = EMPTY;
  
        }
  
      }
  
      //������Ԃ̔z�u
      board[3][3] = BLACK;
      board[3][4] = WHITE;
      board[4][3] = WHITE;
      board[4][4] = BLACK;
  
      //������̐F���w��
      stone = BLACK;
      rev_stone = WHITE;
  
      //�Q�[�����s���t���O
      game = true;
  
    }
  
    static public void showBoard() {
  
      //�܂��󂢂Ă�����W�����邩
      boolean existempty = false;
      //������̐��W�v�p
      int cnt_black = 0;
      //������̐��W�v�p
      int cnt_white = 0;
  
   
  
      //�I�Z���ł�`�ʂ���
      int i = 1;
      System.out.println("  |1 |2 |3 |4 |5 |6 |7 |8 |");
      System.out.println("�\�\�\�\�\�\�\�\�\�\�\�\�\�\");
      for (String[] sarr : board) {
  
        System.out.print(i + " |");
        for (String s : sarr) {
  
          System.out.print(s);
          System.out.print("|");
  
          //�󂢂Ă�����W�����邩�A�e��̏W�v
          if (s.equals(EMPTY)) {
            existempty = true;
          } else if (s.equals(BLACK)) {
            cnt_black++;
          } else if (s.equals(WHITE)) {
            cnt_white++;
          }
  
        }
        System.out.println();
        System.out.println("�\�\�\�\�\�\�\�\�\�\�\�\�\�\");
  
        i++;
  
      }
  
      System.out.println(BLACK + ":" + cnt_black);
      System.out.println(WHITE + ":" + cnt_white);
      System.out.println("�\�\�\�\�\�\�\�\�\�\�\�\�\�\");
  
      if (existempty) {
  
        System.out.println(stone + "�̃^�[���ł�");
      } else {
        System.out.println(stone + "�Q�[���I���I");
        game = false;
      }
  
    }
    
    static public void setStone(int x, int y) {
  
      // �ŊO�̍��W���w�肵���ꍇ
      if (x > 7 || y > 7) {
        System.out.println("���̈ʒu�ɋ�͂����܂���");
      }
  
      // ���z�u�ł���ꍇ
      if (board[y][x].equals(EMPTY)) {
        board[y][x] = stone;
  
        // �Ђ�����Ԃ�����
        turnStone(x, y);
  
        // ������̐ݒ�
        String next_rev_storn = stone;
        stone = rev_stone;
        rev_stone = next_rev_storn;
  
        // �I�Z���ł̕`��
        showBoard();
  
      } else {
  
        // ���ɋ�����Ă���ʒu���w�肵���ꍇ
        System.out.println("���̈ʒu�ɋ�͂����܂���");
      }
  
    }
  
    static public void turnStone(int x, int y) {
  
      // 8�����̋�̔z�u���m�F���A�Ђ�����Ԃ�
  
      turnLeftUp(x, y);
      turnUp(x, y);
      turnRightUp(x, y);
      turnLeft(x, y);
      turnRight(x, y);
      turnLeftDown(x, y);
      turnDown(x, y);
      turnRightDown(x, y);
  
    }
  
    static public void turnLeftUp(int x, int y) {
      if (y > 1 && x > 1) {
  
        // �ƂȂ�̋�
        String next = board[y - 1][x - 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || y - i < 0 || board[y - i][x - i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y - i][x - i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y - t][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnUp(int x, int y) {
      if (y > 1) {
  
        // �ƂȂ�̋�
        String next = board[y - 1][x];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (y - i < 0 || board[y - i][x].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y - i][x].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y - t][x] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRightUp(int x, int y) {
      if (y > 1 && x < 6) {
  
        // �ƂȂ�̋�
        String next = board[y - 1][x + 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || y - i < 0 || board[y - i][x + i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y - i][x + i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y - t][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnDown(int x, int y) {
      if (y < 6) {
  
        // �ƂȂ�̋�
        String next = board[y + 1][x];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (y + i > 7 || board[y + i][x].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y + i][x].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y + t][x] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRight(int x, int y) {
      if (x < 6) {
  
        // �ƂȂ�̋�
        String next = board[y][x + 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || board[y][x + i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y][x + i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnLeftDown(int x, int y) {
      if (y < 6 && x > 1) {
  
        // �ƂȂ�̋�
        String next = board[y + 1][x - 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || y + i > 7 || board[y + i][x - i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y + i][x - i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y + t][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnLeft(int x, int y) {
      if (x > 1) {
  
        // �ƂȂ�̋�
        String next = board[y][x - 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || board[y][x - i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y][x - i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRightDown(int x, int y) {
      if (y < 6 && x < 6) {
  
        // �ƂȂ�̋�
        String next = board[y + 1][x + 1];
  
        // �ƂȂ�̋����̏ꍇ
        if (next.equals(rev_stone)) {
  
          // ����ɂ��̈�ƂȂ肩�珇�Ɋm�F
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || y + i > 7 || board[y + i][x + i].equals(EMPTY)) {
              // ��Ȃ��ꍇ�I��
              break;
            } else if (board[y + i][x + i].equals(stone)) {
              // ����̏ꍇ
  
              // �������̋�����ׂĎ���ɂЂ����肩����
              for (int t = 1; t < i; t++) {
                // �z��̗v�f���㏑��
                board[y + t][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
}