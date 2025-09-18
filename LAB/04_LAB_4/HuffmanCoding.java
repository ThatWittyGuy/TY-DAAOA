import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '\0';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanCoding {

    public static void generateCodes(Node root, String code, Map<Character, String> codes) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            codes.put(root.ch, code);
        }
        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }

    public static Map<Character, String> buildHuffmanTree(char[] chars, int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node merged = new Node(left.freq + right.freq, left, right);
            pq.add(merged);
        }

        Node root = pq.poll();
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        return codes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of characters:");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }
        System.out.println("Enter their frequencies:");
        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        Map<Character, String> huffmanCodes = buildHuffmanTree(chars, freq);

        System.out.println("Huffman Codes:");
        for (char c : chars) {
            System.out.println(c + ": " + huffmanCodes.get(c));
        }
        sc.close();
    }
}
