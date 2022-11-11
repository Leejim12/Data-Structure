package QueenPra;

class Answer {
private int num1;
private int num2;
private int num3;
private int num4;
private int num5;
private int num6;
private int num7;
private int num8;

public Answer(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8) {
	super();
	this.num1 = num1;
	this.num2 = num2;
	this.num3 = num3;
	this.num4 = num4;
	this.num5 = num5;
	this.num6 = num6;
	this.num7 = num7;
	this.num8 = num8;
}
public int getNum1() {
	return num1;
}
public void setNum1(int num1) {
	this.num1 = num1;
}
public int getNum2() {
	return num2;
}
public void setNum2(int num2) {
	this.num2 = num2;
}
public int getNum3() {
	return num3;
}
public void setNum3(int num3) {
	this.num3 = num3;
}
public int getNum4() {
	return num4;
}
public void setNum4(int num4) {
	this.num4 = num4;
}
public int getNum5() {
	return num5;
}
public void setNum5(int num5) {
	this.num5 = num5;
}
public int getNum6() {
	return num6;
}
public void setNum6(int num6) {
	this.num6 = num6;
}
public int getNum7() {
	return num7;
}
public void setNum7(int num7) {
	this.num7 = num7;
}
public int getNum8() {
	return num8;
}
public void setNum8(int num8) {
	this.num8 = num8;
}
@Override
public String toString() {
	return  "[" + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6 + " " + num7 + " " + num8 + "]";
}

}

class AnswerStack{
    private int top;
    private int capacity;
    private Answer stackArray[];
    private String type;

    AnswerStack(String type){
        this.type = type;
        this.top = -1;
        this.capacity = 100;
        stackArray = new Answer[capacity];
    }
    AnswerStack(int capacity){
        this.top = -1;
        this.capacity = capacity;
        stackArray = new Answer[capacity];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top >= this.capacity-1);
    }

    public int size(){
        return this.top+1;
    }
    public void push(Answer element){

        stackArray[++top]  = element;
    }

    public Answer pop(){
        checkIsEmpty();
        Answer ele = stackArray[top];
        stackArray[top] = null;
        --top;
        return ele;
    }

    public Answer peek(){
        checkIsEmpty();
        return stackArray[top];
    }

    public void clear(){
        checkIsEmpty();

        this.top = -1;
        stackArray = new Answer[this.capacity];
    }

    public void printStack(){
        for(Answer ele : stackArray){
            if(ele!=null)
                System.out.print(ele+" ");
        }
    }

    private void checkIsFull(){
        if(isFull()){
            throw new IllegalStateException("스텍이 가득참");
        }
    }
    private void checkIsEmpty(){
        if(isEmpty()){
            throw new IllegalStateException("스텍이 비었음");
        }
    }
}
