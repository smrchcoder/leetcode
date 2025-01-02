from typing import List


def isValidSudoku(board: List[List[str]]) -> bool:
        for i in range(0,len(board)):
            row=board[i]
            element_count={}
            for j in row:
                if j !='.':
                    if(j not in element_count.keys()):
                        element_count[j]=1
                    else:
                        element_count[j]+=1
            print(row)
            print(element_count)
            for k in element_count.values():
                if(k>1):
                    print(k)
                    return False
        for i in range(0,len(board)):
            column_index=i
            element_count={}
            for j in range(0,len(board)):
                if(board[j][column_index]!="."):
                    if(board[j][column_index] not in element_count.keys() ):
                        element_count[board[j][column_index]]=1
                    else:
                        element_count[board[j][column_index]]+=1
            for k in element_count.values():
                if(k>1):
                    return False
        return True

print("Sudoko Validation")
board = [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
print(isValidSudoku(board))