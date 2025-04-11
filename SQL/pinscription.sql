create or replace NONEDITIONABLE PROCEDURE pInscription (
    p_stage_code IN char,
    p_stagiaire_num IN char,
    p_inscription_date IN DATE,
    p_statut_inscription IN char
)
IS
    v_nbinscrit_stage numeric;
    v_nbplace_stage numeric;
BEGIN
    SELECT nbinscrit_stage INTO v_nbinscrit_stage
    FROM stage
    WHERE code_stage = p_stage_code;

    SELECT nbplace_stage INTO v_nbplace_stage
    FROM Stage
    WHERE code_stage = p_stage_code;

    IF v_nbinscrit_stage < v_nbplace_stage THEN
        INSERT INTO Inscription (code_stage, num_stagiaire, date_inscrip, statut_inscrip, code_position)
        VALUES (p_stage_code, p_stagiaire_num, p_inscription_date, p_statut_inscription, '2');

        UPDATE Stage
        SET nbinscrit_stage = v_nbinscrit_stage + 1
        WHERE code_stage = p_stage_code;

        COMMIT; 
    ELSE
        INSERT INTO Inscription (code_stage, num_stagiaire, date_inscrip, statut_inscrip, code_position)
        VALUES (p_stage_code, p_stagiaire_num, p_inscription_date, p_statut_inscription, '3');

        COMMIT;
    END IF;
END;