<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TamagotchiController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/all', [TamagotchiController::class, 'index'])->name('todos');
Route::get('/{codigo?}', [TamagotchiController::class, 'tamagotchi'])->name('uno');
Route::post('/insert', [TamagotchiController::class, 'insertar'])->name('insertar');
Route::get('/banio/{codigo?}', [TamagotchiController::class, 'actualizarBanio'])->name('banio');
Route::get('/Enfermo/{codigo?}', [TamagotchiController::class, 'actualizarEnfermo'])->name('enfermo');
