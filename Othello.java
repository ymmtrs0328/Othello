import java.util.Scanner;

public class Othello {

  public static void main(String[] args){

    Board.initialize();
    Board.showBoard();

    //�R���\�[������̓��͂��󂯕t����
    Scanner s = new Scanner(System.in);

    //�Q�[�����s���t���O��true�̂��������[�v����
    while(Board.game){

      System.out.print("�������x���W����͂��Ă�������:");
      int x = s.nextInt();

      System.out.print("�������y���W����͂��Ă�������:");
      int y = s.nextInt();

      Board.setStone(x-1, y-1);

    }

    s.close();
  }

}