package nqb6uo;

import java.util.LinkedList;

public class Memory {
    final LinkedList<Frame> frames;
    public int error = 0;

    public Memory() {
        frames = new LinkedList<>();
        frames.add(new Frame("A"));
        frames.add(new Frame("B"));
        frames.add(new Frame("C"));
    }

    public void process(int page) {
        frames.forEach(Frame::tick);

        for (Frame frame : frames) {
            if (frame.page == page) {
                frame.use();
                System.out.print('-');
                frames.sort(Frame::compareTo);
                return;
            }
        }

        LinkedList<Frame> changeable = new LinkedList<>();

        for (Frame frame : frames) {
            if (!frame.frozen) {
                changeable.add(frame);
            }
        }

        for (Frame frame : changeable) {
            if (!frame.used) {
                frame.page = page;
                frame.reset();
                System.out.print(frame.id);
                frames.sort(Frame::compareTo);
                error++;
                return;
            }
        }

        for (Frame frame : changeable) {
            frame.page = page;
            frame.reset();
            System.out.print(frame.id);
            frames.sort(Frame::compareTo);
            error++;
            return;
        }

        System.out.print('*');
        error++;

        frames.sort(Frame::compareTo);
    }
}
