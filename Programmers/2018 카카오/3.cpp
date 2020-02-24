/* 2017 KAKAO BLIND RECURITMENT [1차] 캐시
 * 2019.11.09
 */
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string toLower(string s) {
    for (int i = 0; i < s.length(); i++) {
        if (s[i] >= 'A' && s[i] <= 'Z') {
            s[i] += 32;
        }
    }
    return s;
}

int contains(vector<string> cache, string city) {
    for (int j = 0; j < cache.size(); j++) {
        if (cache[j].compare(city) == 0) {
            return j;
        }
    }
    return -1;
}

int solution(int cacheSize, vector<string> cities) {
    vector<string> cache;
    int answer = 0;
    if (cacheSize == 0) {
        answer = cities.size()*5;
    } else {
        for (int i = 0; i < cities.size(); i++) {
            cities[i] = toLower(cities[i]);
            int index = contains(cache, cities[i]);
            if (index >= 0) { // cache hit
                string temp = cache[index];
                cache.erase(cache.begin()+index);
                cache.push_back(temp);
                answer += 1;
            } else {
                // cache init
                if (cache.size() < cacheSize) {
                    cache.push_back(cities[i]);
                } else { // cache miss
                    cache.erase(cache.begin());
                    cache.push_back(cities[i]);
                }
                answer += 5;
            }
        }
    }
    return answer;
}

int main() {
    int size, n;
    string input;
    vector<string> cities;

    cin >> size >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        cities.push_back(input);
    }

    cout << solution(size, cities);
    return 0;
}