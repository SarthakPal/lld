package com.lld.tictactoe.strategies.botplayingstrategies;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
