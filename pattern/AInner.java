public class AInner {
    int innerAge;

    public AInner(int innerAge){
        this.innerAge = innerAge;
    }

    public int getInnerAge() {
        return innerAge;
    }

    public void setInnerAge(int innerAge) {
        this.innerAge = innerAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AInner that = (AInner) o;
        return innerAge == that.innerAge;
    }
    
}
