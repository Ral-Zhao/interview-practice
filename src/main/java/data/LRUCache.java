package data;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private Map<K, Node<K, V>> map;
    private NodeList nodeList;
    private int limit;
    private int count;

    public LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>(limit);
        this.nodeList = new NodeList();
    }

    public void put(K key, V value) {

        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node<K, V>(key, value);
            map.put(key, node);
            if (count + 1 > limit) {
                //超过元素个数限制则删除队尾元素。
                Node<K, V> last = nodeList.removeLast();
                map.remove(last.key);
                nodeList.addFirst(node);
            } else {
                count++;
                nodeList.addFirst(node);
            }
        } else {
            //如果已经存在，将其提高到队首
            nodeList.delete(node);
            nodeList.addFirst(node);
        }
    }
    public int size(){
        return count;
    }

    public V get(K key) {
        Node<K, V> value = map.get(key);
        if (value == null) {
            return null;
        }
        //访问后将其提高到队首
        nodeList.delete(value);
        nodeList.addFirst(value);
        return value.value;
    }

    public V remove(K key) {
        Node<K, V> node = map.remove(key);
        nodeList.delete(node);
        count--;
        return node.value;
    }


    class Node<K, V> {
        private V value;
        private K key;
        private Node<K, V> pre;
        private Node<K, V> next;

        Node(K key, V value) {
            this.value = value;
            this.key = key;
        }
    }

    class NodeList {
        private Node<K, V> head;
        private Node<K, V> tail;

        public Node<K, V> removeLast() {
            Node<K, V> last = tail;
            if (tail != null) {
                if (tail.pre != null) {
                    tail = tail.pre;
                    tail.next = null;
                    last.pre = null;
                    last.next = null;
                } else {
                    head = null;
                    tail = null;
                }

            }
            return last;
        }

        public void addFirst(Node<K, V> node) {
            if (head == null) {
                head = node;
                tail = head;
            } else {
                head.pre = node;
                node.next = head;
                head = node;
            }
        }

        public void delete(Node<K, V> node) {
            if (node == head) {
                if (head != tail) {
                    head = node.next;
                    node.next.pre = null;
                    node.next = null;
                } else {
                    head = null;
                    tail = null;
                }
            } else if (node == tail) {
                removeLast();
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.pre = null;
                node.next = null;
            }
        }
    }
}
