package study.unit2.ex05;

enum Subject {
    CHEMESTRY,
    MATH,
    PHYSIC;

    public boolean isDouble(){
        switch(this)
        {
            case MATH:
                return true;
            default:
                return false;
        }
    }
}
