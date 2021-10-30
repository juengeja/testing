package com.example.kinoticketreservierungssystem.service;

import com.example.kinoticketreservierungssystem.entity.Seat;
import com.example.kinoticketreservierungssystem.entity.ShowEvent;
import com.example.kinoticketreservierungssystem.entity.Ticket;
import com.example.kinoticketreservierungssystem.repository.SeatRepository;
import com.example.kinoticketreservierungssystem.repository.ShowEventRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Set;

@Service
public class TicketPDF {

    @Autowired
    ShowEventRepository showEventRepository;
    @Autowired
    SeatRepository seatRepository;

    private static String FILE = System.getProperty("user.home") + File.separator + "Tickets";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 40,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 23,
            Font.NORMAL);



    public void createTicketPDF(Set<Ticket> tickets) {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(FILE));

            //open
            document.open();
            for (Ticket ticket : tickets) {
                Seat seat = seatRepository.findBySeatID(ticket.getSeatInfo()).get();
                ShowEvent showEvent = showEventRepository.findByShowEventID(ticket.getShowEventInfo()).get();
                Paragraph p = new Paragraph();
                p.add("Movie Ticket");
                p.setAlignment(Element.ALIGN_CENTER);

                document.add(p);

                Paragraph p2 = new Paragraph();
                p2.add("Date: " + showEvent.getEventStart().toString());
                p2.setAlignment(Element.ALIGN_LEFT);
                document.add(p2);

                Paragraph p3 = new Paragraph();
                p3.add("Row: " + (seat.getRow()));
                p3.setAlignment(Element.ALIGN_LEFT);

                document.add(p3);

                Paragraph p4 = new Paragraph();
                p4.add("Number: " + (seat.getSeatNumber()));
                p4.setAlignment(Element.ALIGN_LEFT);
                document.add(p4);

                try {
                    document.add(generateQRCodeImage(ticket.getTicketID()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (tickets.iterator().hasNext()) {
                    document.newPage();
                }
            }
            //close
            document.close();


        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Image generateQRCodeImage(String barcodeText) throws Exception {
        ByteArrayOutputStream stream = QRCode
                .from(barcodeText)
                .withSize(250, 250)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(ImageIO.read(bis), "png", baos);
        Image iTextImage = Image.getInstance(baos.toByteArray());
        return iTextImage;
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}