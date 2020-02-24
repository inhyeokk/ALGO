// BOJ 14890 경사로
#include <iostream>

using namespace std;

int n, l;

bool isPossible(int i, int graph[100][100]) {

    bool slope[100] = {false};
    for (int j = 0; j < n-1; j++) {
        if (graph[i][j] != graph[i][j+1]) {
            int height = graph[i][j] - graph[i][j+1];
            if (height != 1 && height != -1) {
                return false;
            } else if (height == -1) {
                for (int k = 0; k < l; k++) {
                    if (j-k < 0 || slope[j-k]) {
                        return false;
                    }
                    if (graph[i][j] == graph[i][j-k]) {
                        slope[j-k] = true;
                    } else {
                        return false;
                    }
                }
            } else { // height == 1
                for (int k = 0; k < l; k++) {
                    if (j+1+k >= n || slope[j+1+k]) {
                        return false;
                    }
                    if (graph[i][j]-1 == graph[i][j+1+k]) {
                        slope[j+1+k] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

int main() {
    int graph1[100][100];
    int graph2[100][100];

    cin >> n >> l;

    int input;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> input;
            graph1[i][j] = input;
            graph2[j][i] = input;
        }
    }

    int path = 0;
    for (int i = 0; i < n; i++) {
        if (isPossible(i, graph1)) {
            path += 1;
        }
        if (isPossible(i, graph2)) {
            path += 1;
        }
    }
    cout << path;
    return 0;
}