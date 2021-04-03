package model;


class Player{
    //how the player begins (in the middle lane moving forward)
    State player = State.MOVING;

    //x and y coordinate
    int x;
    int y;

    //
    public Player(State Player, int x, int y){
        this.player = Player;
        Coordinate coor = new Coordinate(x, y);

    }

    // {
    // switch (State){
    //     case 1: State = State.JUMP;
    //         break;
    //     case 2: State = State.SPEEDUP;
    //         break;
    //     case 3: State = State.LEFT;
    //         break;
    //     case 4: State = State.RIGHT;
    //         break;
    //     case 5: State = State.DRIVING;
    //         break;
    // }
    //}


    public void jumpTo(){
        //
    }
    
}

//     switch (State){
//         case1: State = State.JUMP;
//             break;
//         case2: State = State.SPEEDUP;
//             break;
//         case3: State = State.LEFT;
//             break;
//         case4: State = State.RIGHT;
//             break;
//         case5: State = State.DRIVING;
//             break;
        


//     }

