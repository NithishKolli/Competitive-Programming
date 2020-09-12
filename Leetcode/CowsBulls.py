#Leetcode 299 - https://leetcode.com/problems/bulls-and-cows/
#easy

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        bulls = 0
        cows = 0
        secret_dict, guess_dict = {}, {}
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
            else:
                secret_dict[secret[i]] = secret_dict.get(secret[i],0) + 1
                guess_dict[guess[i]] = guess_dict.get(guess[i],0) + 1
        for key in secret_dict:
            if key in guess_dict:
                cows += min(secret_dict[key],guess_dict[key])
        return str(bulls)+'A'+str(cows)+'B'
            