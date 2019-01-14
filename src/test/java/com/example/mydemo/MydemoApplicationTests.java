package com.example.mydemo;

import com.example.mydemo.domain.CardVO;
import com.example.mydemo.mapper.CardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MydemoApplicationTests {

    @Autowired
    private CardMapper cardMapper;
    @Test
    public void contextLoads() throws IOException {
        List<CardVO> cardVOS=cardMapper.findAllCard();
        File file=new File("D:\\card.txt");
        if(file.exists()){
            file.delete();
        }

            file.createNewFile();

        BufferedWriter out = new BufferedWriter(new FileWriter(file));


        for(CardVO cardVO:cardVOS){

                out.write(cardVO.getPk_card()+","+cardVO.getCard_code()+","
                            +cardVO.getAsset_code()+","+cardVO.getAsset_name());
                out.newLine();
                out.flush();

        }

        out.close();

    }

}

