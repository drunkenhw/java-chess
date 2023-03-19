package chess.domain.piece;

import chess.domain.board.Position;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    protected boolean validMove(Position sourcePosition, Position targetPosition, Color targetColor) {
        return isStraight(sourcePosition, targetPosition);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Piece move() {
        return new Rook(getColor());
    }
}
