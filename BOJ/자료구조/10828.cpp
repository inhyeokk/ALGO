// BOJ data structure 10825 스택
#include <iostream>
#include <string>

using namespace std;

class Node {
    private:
        int data;
    public:
        Node();
        Node(int data);
        ~Node();
        
        int getData();
};

Node::Node(int data) {
    this->data = data;
}

Node::~Node() {

}

int Node::getData() {
    return this->data;
}

class Stack {
    private:
        int capacity;
        int top;
        Node **nodes;
    public:
        Stack(int capacity);
        ~Stack();

        void push(int data);
        int pop();
        int size();
        int isEmpty();
        int getTop();
};

Stack::Stack(int capacity) {
    this->nodes = new Node*[capacity];
    this->capacity = capacity;
    this->top = 0;
}

Stack::~Stack() {
    for (int i = 0; i < this->capacity; i++) {
        if (this->nodes[i]) {
            delete this->nodes[i];
        }
    }
    delete[] this->nodes;
}

void Stack::push(int data) {
    this->nodes[this->top] = new Node(data);
    this->top += 1;
}

int Stack::pop() {
    if (this->top > 0) {
        this->top -= 1;
        int data = this->nodes[this->top]->getData();
        return data;
    } else {
        return -1;
    }
}

int Stack::size() {
    return this->top;
}

int Stack::isEmpty() {
    return this->top == 0;
}

int Stack::getTop() {
    if (this->top > 0) {
        return this->nodes[this->top-1]->getData();
    } else {
        return -1;
    }
}

int main() {
    int n;
    cin >> n;

    Stack stack = Stack(n);
    string order;
    int num;
    for (int i = 0; i < n; i++) {
        cin >> order;
        if (order.compare("push") == 0) {
            cin >> num;
            stack.push(num);
        } else if (order.compare("pop") == 0) {
            cout << stack.pop() << endl;
        } else if (order.compare("size") == 0) {
            cout << stack.size() << endl;
        } else if (order.compare("empty") == 0) {
            cout << stack.isEmpty() << endl;
        } else if (order.compare("top") == 0) {
            cout << stack.getTop() << endl;
        }
    }

    return 0;
}