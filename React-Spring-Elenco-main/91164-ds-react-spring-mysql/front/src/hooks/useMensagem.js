// src/hooks/useMensagem.js

import { useState, useCallback } from "react";

function useMensagem() {
    const [mensagem, setMensagem] = useState('');
    const [tipoMensagem, setTipoMensagem] = useState('info');
    const [visivel, setVisivel] = useState(false);

    const exibirMensagem = useCallback((texto, tipo = 'sucesso') => {
        setMensagem(texto);
        setTipoMensagem(tipo);
        setVisivel(true);

        const timeoutId = setTimeout(() => {
            setVisivel(false);
        }, 5000);

        return () => clearTimeout(timeoutId); // Limpeza caso precise no futuro
    }, []);

    const fecharMensagem = useCallback(() => {
        setVisivel(false);
    }, []);

    return { mensagem, tipoMensagem, visivel, exibirMensagem, fecharMensagem };
}

export default useMensagem;
