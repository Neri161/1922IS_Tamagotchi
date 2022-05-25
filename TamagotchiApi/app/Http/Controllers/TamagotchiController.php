<?php

namespace App\Http\Controllers;

use App\Models\Tamagotchi;
use Illuminate\Http\Request;
use PHPUnit\Exception;

class TamagotchiController extends Controller
{
    public function index()
    {
        try {
            $tamagotchis = Tamagotchi::all();
            if (!$tamagotchis)
                return json_encode(["estatus" => "error", "mensaje" => "No existe"]);

            return \response($tamagotchis);
        } catch (Exception $e) {
            return json_encode(["estatus" => "error", "mensaje" => $e]);
        }
    }

    public function tamagotchi($codigo)
    {
        try {
            $tamagotchi = Tamagotchi::where('codigo', $codigo)->first();

            if (!$tamagotchi)
                return json_encode(["estatus" => "error", "mensaje" => "No existe"]);

            return \response($tamagotchi);
        } catch (Exception $e) {
            return json_encode(["estatus" => "error", "mensaje" => $e]);
        }
    }

    public function insertar(Request $datos)
    {
        try {
            $tamagotchi = new Tamagotchi();
            $codigo = "";
            for ($x = 0; $x < 6; $x++) {
                $num_aleatorio = rand(0, 9);
                $codigo = $codigo . strval($num_aleatorio);
            }
            $tamagotchi->codigo = $codigo;
            $tamagotchi->nombre = $datos->nombre;
            $tamagotchi->conteo_Banio = 0;
            $tamagotchi->conteo_Enfermo = 0;
            $tamagotchi->save();
            return json_encode(["estatus" => "success", "mensaje" => "Registrado", "Codigo" => $codigo]);
        } catch (Exception $e) {
            return json_encode(["estatus" => "error", "mensaje" => $e]);
        }
    }

    public function actualizarBanio($codigo)
    {
        try {
            $tamagotchi = Tamagotchi::where('codigo', $codigo)->first();
            if (!$tamagotchi)
                return json_encode(["estatus" => "error", "mensaje" => "No existe"]);
            $tamagotchi->ultimo_Banio = now();
            $tamagotchi->conteo_Banio = $tamagotchi->conteo_Banio + 1;
            $tamagotchi->save();
            return json_encode(["estatus" => "success", "mensaje" => "Actualizado"]);
        } catch (Exception $e) {
            return json_encode(["estatus" => "error", "mensaje" => $e]);
        }
    }

    public function actualizarEnfermo($codigo)
    {
        try {
            $tamagotchi = Tamagotchi::where('codigo', $codigo)->first();
            if (!$tamagotchi)
                return json_encode(["estatus" => "error", "mensaje" => "No existe"]);
            $tamagotchi->ultimo_Enfermo = now();
            $tamagotchi->conteo_Enfermo = $tamagotchi->conteo_Enfermo + 1;
            $tamagotchi->save();
            return json_encode(["estatus" => "success", "mensaje" => "Actualizado"]);
        } catch (Exception $e) {
            return json_encode(["estatus" => "error", "mensaje" => $e]);
        }
    }

}
