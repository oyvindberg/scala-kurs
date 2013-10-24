package java;

import scala.Option;

import java.util.ArrayList;
import java.util.List;

public interface Container<M<_>> {
    public abstract <A> M put(A a, M m);
    public abstract <A> scala.Option<A> first(M m);
}

class StringListContainer2 implements Container<List> {

    @Override
    public <A> List<A> put(A a, List list) {
       list.add(a);
       return list;
    }

    @Override
    public <A> Option<A> first(List list) {
        return (Option<A>) Option.apply(list.get(0));
    }

    public static void main(String[] args) {
        StringListContainer2 c = new StringListContainer2();

        List<String> list = c.put(2, new ArrayList<Integer>());

        Option<String> first = c.first(list);
        first.get().charAt(0);

    }
}
