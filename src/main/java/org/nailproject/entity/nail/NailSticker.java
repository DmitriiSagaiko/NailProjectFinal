package org.nailproject.entity.nail;

import lombok.Data;
import org.nailproject.entity.nail.enums.FingerName;
import org.nailproject.entity.nail.enums.Hand;
import org.nailproject.entity.nail.enums.Size;

@Data
public class NailSticker {
    private Hand hand;
    private FingerName fingerName;
    private Size size;
}
