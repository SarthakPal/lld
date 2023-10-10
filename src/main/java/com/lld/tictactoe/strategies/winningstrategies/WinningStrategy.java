package com.lld.tictactoe.strategies.winningstrategies;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move move);
}
