package csv;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        // CSVに書き込む内容を記述
        long[] startTime = {10, 10};
        long[] currentTime = {1000,1000};
        long[] elapsedTime = {100, 100};
        // exportCsvメソッドに渡す
        exportCsv(startTime,currentTime,elapsedTime);
    }

    // CSVファイルを出力するメソッド
    public static void exportCsv(long[] startTime, long[] currentTime, long[] elapsedTime){
        try {
            // 出力ファイルの作成
            FileWriter fw = new FileWriter("Userdata.csv", false);
            // PrintWriterクラスのオブジェクトを生成
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            // ヘッダーの指定
            pw.print("StartTime");
            pw.print(",");
            pw.print("CurrentTime");
            pw.print(",");
            pw.print("ElapsedTime");
            pw.println();
            // データを書き込む
            for(int i = 0; i < startTime.length; i++){
                pw.print(startTime[i]);
                pw.print(",");
                pw.print(currentTime[i]);
                pw.print(",");
                pw.print(elapsedTime[i]);
                pw.println();
            }
            // ファイルを閉じる
            pw.close();
            // 出力確認用のメッセージ
            System.out.println("csvファイルを出力しました");
        // 出力に失敗したときの処理
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}