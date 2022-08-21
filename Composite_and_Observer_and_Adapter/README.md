# Design Pattern 2: Decorator & template method

## 情景
這次你被分配到寫與 Display 相關的程式。

## 目前內容
Display 共有兩種，分別是 StdoutDisplay （輸出至 System.out） 跟 GUIDisplay （顯示於 GUI）。

顯示的 style 可以被遊戲玩家（即遊戲外部）設定，目前可以有兩個選項分別為：Bold （粗體，markdown 為 `**{content}**`）和 Italic （斜體，markdown 為 `*{content}*`）。
而且每個選項可以組合，例如在有這兩個選項的情況下， 可能有 4 種 style 如下：
- plain （兩個都沒選）
- bold （單選 Bold）
- italic （單選 Italic）
- bold and italic （Bold 和 Italic 都選了）

這個 style 以 markdown 的語法作為標記，也就是說只要將原來要顯示的內容適當修改即可。GUI 跟 System.out 將會自動識別並正確顯示（當作他會，懶得寫了）。 

## 要求
這次的要求很簡單，就是要多加上新的 style。條列如下 （`{content}` 代表原來的內容）：
- header 1: `# {content}`
- header 2: `## {content}`
- header 3: `### {content}`
- header 4: `#### {content}`
- header 5: `##### {content}`
- hearer 6: `###### {content}`
- strikeout: `~~{content}~~`

請注意這只是本次新增的內容，後續還有可能再新增別的 style 。

## 關於程式
因為之後還有可能新增 style ，所以會希望新增 style 時能遵守 open-closed principle 。
另外，讓你的程式盡可能的 DRY 。

## 測試
請記得隨著程式結構的變化修改你的測試。
這次的測試比較繁瑣，因為還有組合的問題，我其實也不太確定怎麼測。
個人的建議是將每種 style 單獨測一次，另外再加幾個簡單和複雜的組合測試抽樣檢查，不然全寫出來會有 $2^n$ 種。

## Additional Exercise
這個區塊提供了一些有趣的練習，應該有助於提升對語言的掌握。
主要關於 design pattern 的練習還是在上面的區塊。

- 可以仔細琢磨設定 style 的語法，寫出你覺得方便設定的、對使用者（只程式內的 style 設定者）友善的語法。
- 限制 style 的 order：規則如下（沒有寫的就不用阻止）
  - header 必定出現在最外面（如果有的話）。也就是要阻止這樣的設定：`*# {content}*`
  - 一行只有一個 header 。也就是要阻止這樣的設定：`## ### {content}`