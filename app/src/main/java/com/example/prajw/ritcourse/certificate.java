package com.example.prajw.ritcourse;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.prajw.ritcourse.model.FileUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static com.example.prajw.ritcourse.model.LogUtils.LOGE;

public class certificate extends AppCompatActivity {
    String pname,pemail,cname;
    Context mContext;
    String episode[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        //String details = loadDetails();
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref", 0);
        pname=pref.getString("name", null);
        pemail=pref.getString("email", null);

        //pname = Uri.encode(pname);
        pemail=Uri.encode(pemail);
        mContext = getApplicationContext();
        createPdf(FileUtils.getAppPath(mContext) + "Certificate.pdf");
       // Uri path = Uri.parse("android.resource://com.segf4ult.test/" + R.drawable.icon);
       // String IMG = path.toString();

        //createPdf(Environment.getExternalStorageDirectory().getPath() + "/Certificate.pdf");
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }
    public void createPdf(String dest) {

        if (new File(dest).exists()) {
            new File(dest).delete();
        }

        try {

            final SharedPreferences pref2 = getApplicationContext().getSharedPreferences("MyPref", 0);
            final SharedPreferences.Editor editor = pref2.edit();
            /**
             * Creating Document
             */
            Document document = new Document();

            // Location to save
            PdfWriter.getInstance(document, new FileOutputStream(dest));

            // Open to write
            document.open();

            // Document Settings
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("RSAT");
            document.addCreator("Prajwal P");

            /***
             * Variables for further use....
             */
            BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
            float mHeadingFontSize = 20.0f;
            float mValueFontSize = 26.0f;

            /**
             * How to USE FONT....
             */
            BaseFont urName = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);

            // LINE SEPARATOR
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

            // Title Order Details...
            // Adding Title....
            Font mOrderDetailsTitleFont = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDetailsTitleChunk = new Chunk("Student Result", mOrderDetailsTitleFont);
            Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
            mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mOrderDetailsTitleParagraph);


            // Fields of Order Details...
            // Adding Chunks for Title and value
            Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderIdChunk = new Chunk("Student Name:", mOrderIdFont);
            Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
            document.add(mOrderIdParagraph);

            Font mOrderIdValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderIdValueChunk = new Chunk(pname, mOrderIdValueFont);
            Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);
            document.add(mOrderIdValueParagraph);

            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));

            // Fields of Order Details...
            Font mOrderDateFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderDateChunk = new Chunk("Student Reg Number:", mOrderDateFont);
            Paragraph mOrderDateParagraph = new Paragraph(mOrderDateChunk);
            document.add(mOrderDateParagraph);

            Font mOrderDateValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDateValueChunk = new Chunk("1MS16MCA75", mOrderDateValueFont);
            Paragraph mOrderDateValueParagraph = new Paragraph(mOrderDateValueChunk);
            document.add(mOrderDateValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            // Fields of Order Details...
            Font mOrderDateFont2 = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderDateChunk2 = new Chunk("Course", mOrderDateFont2);
            Paragraph mOrderDateParagraph2 = new Paragraph(mOrderDateChunk2);
            document.add(mOrderDateParagraph2);
            episode=new String[]{"Android Application Development","Introduction to Python","Introduction to Java","Introduction to C"};
            String word = episode[new Random().nextInt(episode.length)];
            Font mOrderDateValueFont2 = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDateValueChunk2 = new Chunk(word, mOrderDateValueFont2);
            Paragraph mOrderDateValueParagraph2 = new Paragraph(mOrderDateValueChunk2);
            document.add(mOrderDateValueParagraph2);
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));


            // Fields of Order Details...
            Font mOrderAcNameFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderAcNameChunk = new Chunk("Marks Scored:", mOrderAcNameFont);
            Paragraph mOrderAcNameParagraph = new Paragraph(mOrderAcNameChunk);
            document.add(mOrderAcNameParagraph);

            Font mOrderAcNameValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Random r = new Random();
            int i1 = r.nextInt(100 - 65) + 65;
            Chunk mOrderAcNameValueChunk = new Chunk(String.valueOf(i1), mOrderAcNameValueFont);
            Paragraph mOrderAcNameValueParagraph = new Paragraph(mOrderAcNameValueChunk);
            document.add(mOrderAcNameValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            InputStream ims = getAssets().open("ritlogo.jpg");
            Bitmap bmp = BitmapFactory.decodeStream(ims);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image image = Image.getInstance(stream.toByteArray());
            image.setAlignment(Image.ALIGN_CENTER);
            Chunk mOrderDetailsTitleChunk2 = new Chunk("Ramaiah Institute Of Technology", mOrderDetailsTitleFont);
            Paragraph mOrderDetailsTitleParagraph2 = new Paragraph(mOrderDetailsTitleChunk2);
            mOrderDetailsTitleParagraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(mOrderDetailsTitleParagraph2);
            document.add(image);
            document.close();

            //Toast.makeText(mContext, "Certficate Generated", Toast.LENGTH_SHORT).show();

            FileUtils.openFile(mContext, new File(dest));

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Error " + ie.getLocalizedMessage());
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(mContext, "No application found to open this file.", Toast.LENGTH_SHORT).show();
        }
    }
}
