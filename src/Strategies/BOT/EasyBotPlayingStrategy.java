package Strategies.BOT;

import Models.Board;
import Models.CellStatus;
import Models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move suggesMove(Board board) {
        int dimension= board.getBoard().size();
       for(int i=0;i<dimension;i++){
           for(int j=0;j<dimension;j++){
               if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY))
                   return new Move(board.getBoard().get(i).get(j));
           }
       }
       return null;
    }
}
