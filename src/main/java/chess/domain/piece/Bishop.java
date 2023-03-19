package chess.domain.piece;

import chess.domain.board.Position;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    protected boolean validMove(Position sourcePosition, Position targetPosition, Color targetColor) {
        return isDiagonal(sourcePosition, targetPosition);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Piece move() {
        return new Bishop(getColor());
    }
}
