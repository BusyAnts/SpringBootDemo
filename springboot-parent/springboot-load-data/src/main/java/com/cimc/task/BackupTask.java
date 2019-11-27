package com.cimc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenz
 * @create 2019-11-27 22:31
 */
@Component
public class BackupTask {

    @Scheduled(cron = "0 */1 * * * *")
    public void backup() {
        System.out.println("开始执行备份");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        String folderName = sdf.format(date);
        try {
            FileReader fr = new FileReader("/home/backup/config.txt");
            BufferedReader bfr = new BufferedReader(fr);
            String baseDir = bfr.readLine();
            bfr.close();
            fr.close();
            String shell = "innobackupex --defaults-file=/etc/my.cnf " +
                    "--user=admin --password=Abc_123456 --port=3306 --no-timestamp " +
                    "--incremental-basedir=" + baseDir + " " +
                    "--incremental /home/backup/increment/java/" + folderName;
            Runtime.getRuntime().exec(shell);
            FileWriter fw = new FileWriter("/home/backup/config.txt");
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("/home/backup/increment/java/" + folderName);
            bfw.close();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
