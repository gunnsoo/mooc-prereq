def select_sort(data):
    """選択ソート：自分よりも小さな値と場所を入れ替えて，昇順に並べ替える"""
    for i in range(len(data)):
        Min = i     #入れ替え対象をセット
        for j in range(i+1, len(data)):
            #セットした値よりも小さな値があれば，その位置を最小値として記録
            if  data[j] < data[Min]:
                Min = j
        #いまの位置と最小値を入れ替え ⇒ 結果，左から小さい順に並ぶ
        data[i], data[Min] = data[Min], data[i]
        print(data)

    return data     #並べ替えを終えたデータを返す

select_sort([11,6,2,7,5,3,13,10,1,12])