import dsa.Set;

import java.util.Iterator;

import stdlib.StdOut;

// An iterable data type to represent an ordered set.
public class SetX<Key extends Comparable<Key>> implements Iterable<Key> {
    private Set<Key> set; // the underlying set.

    // Constructs an empty set.
    public SetX() {
        set = new Set<Key>();
    }

    // Constructs a set from the given keys.
    public SetX(Key[] keys) {
        this();
        for (Key key : keys) {
            add(key);
        }
    }

    // Returns true if this set is empty, and false otherwise.
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // Returns the number of keys in this set.
    public int size() {
        return set.size();
    }

    // Adds key to this set, if it is not already present.
    public void add(Key key) {
        set.add(key);
    }

    // Returns true if this set contains key, and false otherwise.
    public boolean contains(Key key) {
        return set.contains(key);
    }

    // Deletes key from this set.
    public void delete(Key key) {
        set.delete(key);
    }

    // Returns an iterator to iterate over the keys in this set in sorted order.
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    // Returns a string representation of this set.
    public String toString() {
        return set.toString();
    }

    // Returns the union of this set and other, ie, the keys that are either in this set or other.
    public Set<Key> union(SetX<Key> other) {
        // loop
        Set<Key> u = new Set<Key>();
        for(Key key : this) {
            u.add(key);
        }
        for(Key key : other) {
            u.add(key);
        }
        return u;
    }

    // Returns the intersection of this set and other, ie, the keys that are in this set and other.
    public SetX<Key> intersection(SetX<Key> other) {
        // ig other does have it we add
        // intersection
        SetX<Key> i = new SetX();
        for(Key key : this.set) {
            if(other.contains(key)) {
                i.add(key);
            }
        }
        return i;
    }

    // Returns the difference of this set and other, ie, the keys that are in this set but not
    // other.
    public SetX<Key> difference(SetX<Key> other) {
        // if other doesnt we add
        SetX<Key> d = new SetX();
        for(Key key : this.set) {
            if(!(other.contains(key))) {
                d.add(key);
            }
        }
        return d;
    }

    // Returns the symmetric difference of this set and other, ie, the keys that are in this set
    // or other but not both.
    public SetX<Key> symmetricDifference(SetX<Key> other) {
        return null;
    }

    // Returns true if this set and other have the same keys, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        SetX<Key> a = this, b = (SetX<Key>) other;
        return a.set == b.set;
    }

    // Returns true if this set and other have no keys in common, and false otherwise.
    public boolean isDisjoint(SetX<Key> other) {
        // loop and see if they have no keys in common
        for(Key key : this) {
            if(other.contains(key)) {
                return false;
            }
        }
        return true;
    }

    // Returns true if this set is contained in other, and false otherwise.
    public boolean isSubset(SetX<Key> other) {
        // loop through this set and use contains function to check for keys in other
        for(Key key : this) {
            if(!(other.contains(key))) {
                return false;
            }
        }
        return true;
    }

    // Returns true if this set contains other, and false otherwise.
    public boolean isSuperset(SetX<Key> other) {
        return isSubset(other);
    }

    // Unit tests the data type [DO NOT EDIT].
    public static void main(String[] args) {
        SetX<Character> a =
                new SetX<Character>(new Character[]{'e', 'i', 'n', 's', 't', 'e', 'i', 'n'});
        SetX<Character> b = new SetX<Character>(new Character[]{'d', 'a', 'r', 'w', 'i', 'n'});
        SetX<Character> c = new SetX<Character>(new Character[]{'s', 't', 'e', 'i', 'n'});
        SetX<Character> d = new SetX<Character>(new Character[]{'b', 'u', 'd', 'd', 'h', 'a'});
        SetX<Character> e = new SetX<Character>(new Character[]{'e', 'i', 'n'});
        SetX<Character> f = new SetX<Character>(new Character[]{'a', 'e', 'i', 'n'});
        StdOut.println("a                        = " + a);
        StdOut.println("b                        = " + b);
        StdOut.println("c                        = " + c);
        StdOut.println("d                        = " + d);
        StdOut.println("e                        = " + e);
        StdOut.println("f                        = " + f);
        StdOut.println("a.union(b)               = " + a.union(b));
        StdOut.println("a.intersection(b)        = " + a.intersection(b));
        StdOut.println("a.difference(b)          = " + a.difference(b));
        StdOut.println("b.difference(a)          = " + b.difference(a));
        StdOut.println("a.symmetricDifference(b) = " + a.symmetricDifference(b));
        StdOut.println("a.equals(b)              = " + a.equals(b));
        StdOut.println("a.equals(c)              = " + a.equals(c));
        StdOut.println("a.isDisjoint(b)          = " + a.isDisjoint(b));
        StdOut.println("a.isDisjoint(d)          = " + a.isDisjoint(d));
        StdOut.println("a.isSubset(e)            = " + a.isSubset(e));
        StdOut.println("e.isSubset(a)            = " + e.isSubset(a));
        StdOut.println("f.isSubset(a)            = " + f.isSubset(a));
        StdOut.println("a.isSuperset(e)          = " + a.isSuperset(e));
        StdOut.println("e.isSuperset(a)          = " + e.isSuperset(a));
        StdOut.println("a.isSuperset(f)          = " + a.isSuperset(f));
    }
}