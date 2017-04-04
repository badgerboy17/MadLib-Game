package edu.uwp.csci242.assignment.a04.madlib;

/**
 * Created by brycesulin on 4/1/17.
 * ArrayBag is a generic collection class that holds references to objects
 * <p>
 * Each ArrayBag type holds a different type of word (e.g. nouns, plural nouns)
 * <p>
 *
 * @author brycesulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 4
 * @bugs none
 */
public class ArrayBag<E> implements Cloneable {

    /**
     * list variable array stores the elements of the ArrayBag
     */
    private Object[] list;

    /**
     * numberItems variable tracks the number of elements in the ArrayBag
     */
    private int numberItems;

    /**
     * Default no-arg constructor for ArrayBag
     * Creates an empty ArrayBag with initial capacity of DEFAULT_INITIAL_CAPACITY
     */
    public ArrayBag () {
        final int DEFAULT_INITIAL_CAPACITY = 10;
        numberItems = 0;
        list = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Single argument constructor for ArrayBag
     * Creates an empty ArrayBag with the given initial capacity
     * @throws IllegalArgumentException if initial capacity is negative
     * @param initialCapacity is the initial capacity of the ArrayBag
     */
    public ArrayBag (int initialCapacity) throws IllegalArgumentException {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Negative Capacity: " + initialCapacity);
        }
        list = new Object[initialCapacity];
        numberItems = 0;
    }

    /**
     * Accessor method to determine the current capacity
     * @return the current capacity of the ArrayBag
     */
    public int getCapacity() {
        return list.length;
    }

    /**
     * Accessor method to determine the number of items in the ArrayBag
     * @return the current number of items in this ArrayBag
     */
    public int getSize() {
        return numberItems;
    }

    /**
     * Add a new element to the ArrayBag
     * @param element is the new element being added
     */
    public void add(E element) {
        if (numberItems == list.length) {
            ensureCapacity((numberItems + 1) * 2);
        }

        list[numberItems] = element;
        numberItems++;
    }

    /**
     * Add the contents of another ArrayBag to this ArrayBag
     * @param addend ArrayBag whose contents will be added to this ArrayBag
     */
    public void addAll (ArrayBag<E> addend) {
        ensureCapacity(numberItems + addend.numberItems);

        System.arraycopy(addend.list, 0, list, numberItems, addend.numberItems);
        numberItems += addend.numberItems;
    }

    /**
     * Add a variable number of new elements to this ArrayBag
     * @param elements a variable number of new elements to add to the ArrayBag
     */
    public void addMany (E... elements) {
        if (numberItems + elements.length > list.length) {
            ensureCapacity((numberItems + elements.length) * 2);
        }

        System.arraycopy(elements, 0, list, numberItems, elements.length);
        numberItems += elements.length;
    }

    /**
     * Change the current capacity of this ArrayBag
     * @param minimumCapacity the new capacity for this ArrayBag
     */
    public void ensureCapacity (int minimumCapacity) {
        Object biggerArray[];

        if (list.length < minimumCapacity) {
            biggerArray = new Object[minimumCapacity];
            System.arraycopy(list, 0, biggerArray, 0, numberItems);
            list = biggerArray;
        }
    }

    /**
     * Generate a copy of this ArrayBag
     * @return a copy of this ArrayBag
     * @throws CloneNotSupportedException if clone() not supported
     */
    public ArrayBag<E> clone() throws CloneNotSupportedException {
        ArrayBag<E> copy;

        try {
            copy = (ArrayBag<E>) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException("Class does not implement Cloneable");
        }

        copy.list = list.clone();
        return copy;
    }

    /**
     * Accessor method to count the number of occurrences of a particular element in this ArrayBag
     * @param target the reference to an E object to be counted
     * @return the number of times the given target occurs in this ArrayBag
     */
    public int countOccurances (E target) {
        int count = 0;

        for (int i = 0; i < numberItems; i++) {
            if (target == list[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Accessor method to retrieve a random element from this ArrayBag
     * @return a randomly selected element from this ArrayBag
     * @throws IllegalStateException if empty ArrayBag
     */
    @SuppressWarnings("unchecked")
    public E grab () throws IllegalStateException {
        int i;

        if (numberItems == 0) {
            throw new IllegalStateException("Bag size is zero");
        }

        i = (int)(Math.random() * numberItems);
        return (E) list[i];
    }

    /**
     * Remove one specified element from this ArrayBag
     * @param target the element to remove from this ArrayBag
     * @return True if element was removed from ArrayBag, otherwise false
     */
    public boolean remove (E target) {
        int index;

        if (target == null) {
            index = 0;
            while ((index < numberItems) && (list[index] != null))
                index++;
        }
        else {
            index = 0;
            while ((index < numberItems) && (!target.equals(list[index])))
                index++;
        }

        if (index == numberItems) {
            return false;
        }
        else {
            numberItems--;
            list[index] = list[numberItems];
            list[numberItems] = null;
            return true;
        }
    }

    /**
     * Reduce the current capacity of this ArrayBag to its size
     */
    public void trimToSize () {
        Object[] trimmedArray;

        if (list.length != numberItems) {
            trimmedArray = new Object[numberItems];
            System.arraycopy(list, 0, trimmedArray, 0, numberItems);
            list = trimmedArray;
        }
    }

    /**
     * Create a new ArrayBag that contains all of the elements from two other ArrayBags
     * @param b1 an ArrayBag to be combined
     * @param b2 an ArrayBag to be combined
     * @param <E> Type of ArrayBag
     * @return a new ArrayBag that is the combination of b1 and b2
     */
    public static <E> ArrayBag<E> combine(ArrayBag<E> b1, ArrayBag<E> b2) {
        ArrayBag<E> combineArray = new ArrayBag<E>(b1.getCapacity() + b2.getCapacity());

        System.arraycopy(b1.list, 0, combineArray.list, 0, b1.numberItems);
        System.arraycopy(b2.list, 0, combineArray.list, b1.numberItems, b2.numberItems);
        combineArray.numberItems = b1.numberItems + b2.numberItems;

        return combineArray;
    }
}