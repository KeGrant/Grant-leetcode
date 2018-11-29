class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        whitespace = True
        sign = True
        start = True
        numstr = ""
        for i in range(len(str)):
            if whitespace and str[i] == ' ':
                continue
            if whitespace and str[i] != ' ':
                whitespace = False
            if whitespace == False:
                if str[i] != '-' and str[i] != '+' and (str[i] < '0' or str[i] > '9'):
                    break
                if (not(sign and start)) and (str[i] == '-' or str[i] == '+'):
                    break
                if sign and start and (str[i] == '-' or str[i] == '+'):
                    sign = False
                    numstr += str[i]
                if str[i] >= '0' and str[i] <='9':
                    start = False
                    numstr += str[i]
        
        negative = False
        res = 0
        for i in range(len(numstr)):
            if numstr[i] == '-':
                negative = True
                continue
            elif numstr[i] == '+':
                continue
            else:
                if negative:
                    if res > 214748364 or (res == 214748364 and numstr[i] > '8'):
                        return -2147483648
                    else:
                        num = int(numstr[i])
                        res *= 10
                        res += num
                else:
                    if res > 214748364 or (res == 214748364 and numstr[i] > '7'):
                        return 2147483647
                    else:
                        num = int(numstr[i])
                        res *= 10
                        res += num
        if negative:
            res = res * -1
        
        return res
