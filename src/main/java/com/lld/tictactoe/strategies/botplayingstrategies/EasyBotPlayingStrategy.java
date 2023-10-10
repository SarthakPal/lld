package com.lld.tictactoe.strategies.botplayingstrategies;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Cell;
import com.lld.tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell makeMove(Board board) {

        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return cell;
                }
            }
        }

        return null; // You should never come here
    }
}
