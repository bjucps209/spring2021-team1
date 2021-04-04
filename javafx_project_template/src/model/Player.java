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
    //         //jumpUp()
    //     case 2: State = State.SPEEDUP;
    //         break;
    //         //speedUp();
    //     case 3: State = State.LEFT;
    //         break;
    //     case 4: State = State.RIGHT;
    //         break;
    //     case 5: State = State.DRIVING;
    //         break;
    // }
    // }

    /**
     * @return none
     * @param int:x
     * @param int:y
     */
    public void jumpUp(){
        // break;
    }

    /**
     * @return none 
     * @param none
     * make the view go faster meaning adding more in x over a faster period of times
     */
    public void speedUp(){
        // break;
    }

    /**
     * @return none
     * @param State:state
     * changing lanes to the left: if its already left by gettingcurrentstate then dont move the y; if the player is on
     * the right or the middle lane add y
     */
    public void leftLane(){
        // break;
    }

    /**
     * @return none
     * @param State:state
     * changing lanes to the right: if its already right by gettingcurrentstate then dont move the y; if the player is on
     * the left or the middle lane add y
     */
    public void rightLane(){
        // break;
    }


    /**
     * @return none
     * @param none
     * get the y, if its 0, the current state is right lane, if its a 1 its the middle lane, and if its the 2 its the left lane
     */
    public void getCurrentState(){
        // break;
    }

    public void serialize() {

    }

    public void deserialize() {
        
    }
}
