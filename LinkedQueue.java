// Student Name: Ange Michaella Niyonkuru
// Student ID: 8962161
// Section C
// Assignment 3

public class LinkedQueue<E> implements Queue<E>{

	private static class Elem<T>{
		private T value;
		private Elem<T> next;
		private Elem(T value, Elem<T> next){
			this.value=value;
			this.next=next;
		}
	}

	private Elem<E> front;
	private Elem<E> rear;

	public E peek(){
		return front.value;
	}

	public void enqueue(E o){
		Elem<E> tempElem;
		tempElem=new Elem<E>(o,null);
		if(rear==null){
			front=rear=tempElem;
		}
		else{
			rear.next=tempElem;
			rear=tempElem;
		}
	}

	public E dequeue(){
		E result=front.value;
		if(front!=null && front.next==null){
			front=rear=null;
		}else{
			front=front.next;
		}
		return result;
	}

	public boolean isEmpty(){
		return front==null;
	}
}