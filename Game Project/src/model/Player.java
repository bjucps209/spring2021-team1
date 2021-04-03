package model;


class Player{
    State player = State.MOVING;
    int x;
    int y;

    public Player(State Player, int x, int y){
        this.player = Player;
        Coordinate coor = new Coordinate(x, y);

    }

    {
    switch (State){
        case 1: State = State.JUMP;
            break;
        case 2: State = State.SPEEDUP;
            break;
        case 3: State = State.LEFT;
            break;
        case 4: State = State.RIGHT;
            break;
        case 5: State = State.DRIVING;
            break;
    }
    }


    public void jumpTo(){
        //
    }
    
}

